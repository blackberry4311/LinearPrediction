package model;

public class Stored {
	private Integer X;
	private Double Y;
	private Double xMultiplyY;
	private Double xSquare;

	public Stored(Integer x, Double y) {
		X = x;
		Y = y;
		this.xMultiplyY = x * y;
		this.xSquare = Math.pow(x, 2);
	}

	public Integer getX() {
		return X;
	}

	public void setX(Integer x) {
		X = x;
	}

	public Double getY() {
		return Y;
	}

	public void setY(Double y) {
		Y = y;
	}

	public Double getxMultiplyY() {
		return xMultiplyY;
	}

	public void setxMultiplyY(Double xMultiplyY) {
		this.xMultiplyY = xMultiplyY;
	}

	public Double getxSquare() {
		return xSquare;
	}

	public void setxSquare(Double xSquare) {
		this.xSquare = xSquare;
	}
}
