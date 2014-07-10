import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GifPlayer extends com.javacore.FilePlayer {
	
	protected int status;
	protected int FrameCount;
	public BufferedImage image;
	protected ArrayList frames;
	protected BufferedInputStream in;
	public void read(BufferedInputStream fileToPlay){
		if(fileToPlay!=null){
			 if (!(fileToPlay instanceof BufferedInputStream))
			        fileToPlay = new BufferedInputStream(fileToPlay);
			 		in = (BufferedInputStream) fileToPlay;
			 		

			 		
			 		
		}
		try {
		      fileToPlay.close();
		    } catch (IOException e) {
		    }
	}
	

<<<<<<< HEAD

    @Override
    protected BufferedImage getNextFrame() {
        BufferedImage frame = decoder.getFrame(lastFrameIndex);
        lastFrameIndex++;
        return frame;
    }

=======
	public BufferedImage getFrame(int n){
		BufferedImage im = null;
	    if ((n >= 0) && (n < FrameCount)) {
	      im = ((GifPlayer) frames.get(n)).image;
	    }
	    return im;
	}
	public int getFrameCount(){
		return FrameCount;
	}
>>>>>>> 6bc0747d70940c0ecee370abb30b953b1fbd87ad
	
}
