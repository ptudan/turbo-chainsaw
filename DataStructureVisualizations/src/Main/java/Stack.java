

public class Stack{
	private stackNode top;
	private int size;

	public Stack(){
		size = 0;
	}

	public void push(int x){
		if(top == null){
			top = new stackNode(x, null);
		}
		else{
			top = new stackNode(x, top);
		}
		size++;
	}

	public int pop(){
		if(top == null){
			System.out.println("error");
			return -1;
		}
		else{
			int x = top.getData();
			top = top.getPrev();
			size--;
			return x;
		}
	}

	public int getSize(){
		return size;
	}

	public int peek(){
		if(top == null){
			System.out.println("Error");
			return -1;
		}
		else{
			return top.getData();
		}
	}
}