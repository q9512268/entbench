package camera; 

public class RaspiStill {
	// Define the path to the raspistill executable.
	private final String _raspistillPath = "/opt/vc/bin/raspistill";
	// Define the amount of time that the camera will use to take a photo.
	private int _picTimeout = 30000;

	// Specify a default image width.
	private int _picWidth = 1024;
	// Specify a default image height.
	private int _picHeight = 768;
	// Specify a default image name.
	private String _picName = "example.jpg";
	// Specify a default image encoding.
	private String _picType = "jpg";

	private String _picNames = "example%d.jpg";

  private int _picLapse = 1000;

	private int _quality = 100;

	public void RaspiStill() {
	}

	public void TakePicture(int timeout, String name) throws Exception {
			// Create a new string builder with the path to raspistill.
			StringBuilder sb = new StringBuilder(_raspistillPath);

			// Add parameters for no preview and burst mode.
			sb.append(" -n -bm");
			// Configure the picture width.
			sb.append(" -w " + _picWidth);
			// Configure the picture height.
			sb.append(" -h " + _picHeight);
			// Specify the image type.
			sb.append(" -e " + _picType);

			// Specify the image type.
			sb.append(" -q " + _quality);

			// Specify the image type.
			sb.append(" -t 1");

			// Specify the name of the image.
			sb.append(" -o " + name);

			// Invoke raspistill to take the photo.
			System.out.println(sb.toString());
			Runtime.getRuntime().exec(sb.toString());
			// Pause to allow the camera time to take the photo.
	} 

	public void TakePictures() {
		try {
			int npics = _picTimeout / _picLapse;
			System.out.format("Taking %d pictures", npics);
			for (int i = 0; i < npics; i++) {
				TakePicture(_picLapse, "example" + i + "%d.jpg");
				Thread.sleep(_picLapse);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// Overloaded method to take a photo using specific values for the name/width/height.
	public void TakePictures(int width, int height, int lapse, int timeout) {
		_picWidth = width;
		_picHeight = height;
		_picLapse = lapse;
		_picTimeout = timeout;
		TakePictures();
	}

}
