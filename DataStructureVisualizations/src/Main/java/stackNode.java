

public class stackNode{
	private int data;
	private stackNode prev;

	public stackNode(int x, stackNode s){
		data = x;
		prev = s;
	}

	public int getData(){
		return data;
	}

	public stackNode getPrev(){
		return prev;
	}
}