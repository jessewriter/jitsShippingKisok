package jesseboyd.jitsShipping.dimensions;

public abstract class Dimmensions {

	private int depth;
	private int width;
	private int height;

	public Dimmensions(int depth, int width, int height) {
		this.depth = depth;
		this.width = width;
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public double getVolumeInInches() {
		return depth * width * height;
	}
	
	public double getVolumeInFeet() {
		return getVolumeInInches() * 0.000578704;
	}
	
}
