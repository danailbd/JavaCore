package com.javacore;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.Thread.State;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import jline.ConsoleReader;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;

public class VideoPlayer extends SequencePlayer {
	
	/**
	 * Used for saving heap memory
	 */
	final int MAX_BUFFER_SIZE = 100;
	
	private boolean endOfFrames = false;
	
	Thread mainThread = Thread.currentThread();
	
	Queue<BufferedImage> bufferedFrames = new ConcurrentLinkedQueue<>();
	int curFrame = 0;
	
	public VideoPlayer() {
		super();
	}

	public VideoPlayer(int consoleWidth, int hIndex) {
		super(consoleWidth, hIndex);
	}
	
	public VideoPlayer(int consoleWidth, int hIndex, int playSpeed) {
		super(consoleWidth, hIndex, playSpeed);
	}

	/**
	 * Decodes frames of the video to Buffered images.Then adds them to the queue
	 * @param currentLastFrame
	 * @param l
	 * @return
	 * @throws IOException
	 * @throws JCodecException
	 */
	private void addFramesToQuese(int from, int to)
			throws IOException, JCodecException{
		
		while(from<to){
			try{
			BufferedImage frame = FrameGrab.getFrame(file, from);
			bufferedFrames.add(frame);
			} catch(Exception e){}
			
			++from;
		}	
	}

	@Override
	public void play() throws IOException{
		
		treadBufferingLogic();

		while(!endOfFrames){
			new ConsoleReader().clearScreen();
			
			BufferedImage frame = bufferedFrames.poll();
			if(frame == null){
				System.out.println("Buffering ...");
				try {
					Thread.sleep(100000);
				} catch (InterruptedException e) { }
				continue;
			}
			
			System.out.println(getASCII_Image(frame));
			try {
				Thread.sleep(playSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}

	/**
	 * Implements simple thread logic for buffering images
	 */
	private void treadBufferingLogic() {
		Thread bufferingThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				final int BUFFER_IMAGE_STEP = 5;
				
				for(int i = 0; !endOfFrames; i+=5){
					
					try {
						addFramesToQuese(i, i + BUFFER_IMAGE_STEP);
					} catch (JCodecException e) {
						endOfFrames = true;
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//Sleeps the thread until some images are printed ( 24 frames a second )
					if(bufferedFrames.size() > MAX_BUFFER_SIZE){
						try {
							Thread.sleep(playSpeed*50);
						} catch (InterruptedException e) { }
					}
					if(bufferedFrames.size() > 50 && mainThread.getState() == State.TIMED_WAITING){
						mainThread.interrupt();
					}
				}
			}

		});
		
		bufferingThread.start();
	}

}
