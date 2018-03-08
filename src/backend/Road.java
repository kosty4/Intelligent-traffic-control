package backend;

public class Road {

	private Intersection beginning;
	private Intersection end;
	private int lanes;
	private int speedLimit;
	private int distance;
	private boolean blocked;
	private int level;
	
	public Road(int distance, Intersection beginning, Intersection end) {
		this.distance = distance;
		this.beginning = beginning;
		this.end = end;9
		this.lanes = 1;
		this.speedLimit = 80;
		this.blocked = false;
		this.level = 1;
	}
	
	public Road(int distance, Intersection beginning, Intersection end, int level) {
		this.distance = distance;
		this.beginning = beginning;
		this.end = end;
		this.lanes = 1;
		this.speedLimit = 80;
		this.blocked = false;
		this.level = level;
	}
	
	public Road(int distance, Intersection beginning, Intersection end, int lanes, int level, int speedLimit, boolean blocked) {
		this.distance = distance;
		this.beginning = beginning;
		this.end = end;
		this.lanes = lanes;
		this.speedLimit = speedLimit;
		this.blocked = blocked;
		this.level = level;
	}

	public Intersection getBeginning() {
		return beginning;
	}

	public void setBeginning(Intersection beginning) {
		this.beginning = beginning;
	}

	public Intersection getEnd() {
		return end;
	}

	public void setEnd(Intersection end) {
		this.end = end;
	}

	public int getLanes() {
		return lanes;
	}

	public void setLanes(int lanes) {
		this.lanes = lanes;
	}

	public int getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
