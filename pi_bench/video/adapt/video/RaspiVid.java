package video; 

public class RaspiVid {
	// Define the path to the raspistill executable.
	private final String _raspividPath = "/opt/vc/bin/raspivid";
	// Define the amount of time that the camera will use to take a photo.
	//private final int _vidTimeout = 120000;
	private int _vidTimeout = 120000;


	private String _vidName = "vid.mp4";

	// Specify a default image width.
	private int _vidWidth = 1920;
	// Specify a default image height.
	private int _vidHeight = 1080;
	// Specify a default image name.

  private int _fps = 30;

	public void RaspiVid() {
	}

	public void TakeVideo() {
		try {
			StringBuilder sb = new StringBuilder(_raspividPath);

			sb.append(" -n ");
			sb.append(" -t " + _vidTimeout);
			sb.append(" -w " + _vidWidth);
			sb.append(" -h " + _vidHeight);
			sb.append(" -fps " + _fps);
			sb.append(" -o " + _vidName);

			System.out.println(sb.toString());

			Runtime.getRuntime().exec(sb.toString());
			Thread.sleep(_vidTimeout);
		} catch (Exception e) {
	  	System.exit(e.hashCode());
		}
	} 

	// Overloaded method to take a photo using specific values for the name/width/height.
	public void TakeVideo(String name, int width, int height, int fps, int timeout) {
		_vidName = name;
		_vidWidth = width;
		_vidHeight = height;
		_fps = fps;
		_vidTimeout = timeout;
		TakeVideo();
	}
}

