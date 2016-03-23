package camera; 

public class RaspiStill@mode<?->X> {
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

  attributor {
		if (_picHeight <= 1200) {
			return @mode<low>;
		} else if (_picHeight <= 1536) {
			return @mode<mid>;
		} else {
			return @mode<high>;
		}
  }

	public RaspiStill(int width, int height) {
		_picWidth = width;
		_picHeight = height;
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
		if (_picLapse < 1000) {
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
		} else {
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
	}

	// Overloaded method to take a photo using specific values for the name/width/height.
	public void TakePictures(int lapse, int timeout) {
		_picLapse = lapse;
		_picTimeout = timeout;
		TakePictures();
	}

}
