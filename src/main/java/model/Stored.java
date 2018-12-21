package model;

public class Stored {
	private Integer X;
	private Double Y;
	private Double xMultiplyY;
	private Double xSquared;
	private Double ySquared;

	public Stored(Integer x, Double y) {
		X = x;
		Y = y;
		this.xMultiplyY = x * y;
		this.xSquared = Math.pow(x, 2);
		this.ySquared = Math.pow(y, 2);
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

	public Double getxSquared() {
		return xSquared;
	}

	public void setxSquared(Double xSquared) {
		this.xSquared = xSquared;
	}

	public Double getySquared() {
		return ySquared;
	}

	public void setySquared(Double ySquared) {
		this.ySquared = ySquared;
	}
}
