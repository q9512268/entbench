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

	public void TakePicture() {
		try {
			// Determine the image type based on the file extension (or use the default).
			if (_picName.indexOf('.')!=-1) _picType = _picName.substring(_picName.lastIndexOf('.')+1);

			// Create a new string builder with the path to raspistill.
			StringBuilder sb = new StringBuilder(_raspistillPath);

			// Add parameters for no preview and burst mode.
			sb.append(" -n -bm");
			// Configure the camera timeout.
			sb.append(" -t " + _picTimeout);
			// Configure the picture width.
			sb.append(" -w " + _picWidth);
			// Configure the picture height.
			sb.append(" -h " + _picHeight);
			// Specify the image type.
			sb.append(" -e " + _picType);

			// Specify the image type.
			sb.append(" -q " + _quality);

			// Specify the name of the image.
			sb.append(" -o " + _picName);

			// Invoke raspistill to take the photo.
			Runtime.getRuntime().exec(sb.toString());
			// Pause to allow the camera time to take the photo.
			Thread.sleep(_picTimeout);
		} catch (Exception e) {
	 		// Exit the application with the exception's hash code.
	  	System.exit(e.hashCode());
		}
	} 

	// Overloaded method to take a photo using specific values for the name/width/height.
	public void TakePicture(String name, int width, int height) {
		_picName = name;
		_picWidth = width;
		_picHeight = height;
		TakePicture();
	}

	// Overloaded method to take a photo using a specific value for the image name.
	public void TakePicture(String name) {
		TakePicture(name, _picWidth, _picHeight);
	}

	// Overloaded method to take a photo using specific values for width/height.
	public void TakePicture(int width, int height) {
		TakePicture(_picName, width, height);
	}

	public void TakePictures() {
		try {
			// Determine the image type based on the file extension (or use the default).
			if (_picName.indexOf('.')!=-1) _picType = _picName.substring(_picName.lastIndexOf('.')+1);

			// Create a new string builder with the path to raspistill.
			StringBuilder sb = new StringBuilder(_raspistillPath);

			// Add parameters for no preview and burst mode.
			sb.append(" -n -bm");
			// Configure the camera timeout.
			sb.append(" -t " + _picTimeout);
			// Configure the picture width.
			sb.append(" -w " + _picWidth);
			// Configure the picture height.
			sb.append(" -h " + _picHeight);
			// Configure the picture quality.
			sb.append(" -e " + _picType);

			// Specify the timelapse
			sb.append(" -tl " + _picLapse);

			// Specify the timelapse
			sb.append(" -q " + _quality);

			// Specify the name of the image.
			sb.append(" -o " + _picNames);

		  System.out.println(sb.toString());

			// Invoke raspistill to take the photo.
			Runtime.getRuntime().exec(sb.toString());
			// Pause to allow the camera time to take the photo.
			Thread.sleep(_picTimeout);
		} catch (Exception e) {
	 		// Exit the application with the exception's hash code.
	  	System.exit(e.hashCode());
		}
	}

	// Overloaded method to take a photo using specific values for the name/width/height.
	public void TakePictures(String name, int width, int height, int lapse, int timeout) {
		_picName = name;
		_picWidth = width;
		_picHeight = height;
		_picLapse = lapse;
		_picTimeout = timeout;
		TakePictures();
	}

}
