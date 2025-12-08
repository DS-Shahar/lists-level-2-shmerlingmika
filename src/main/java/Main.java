import java.util.*;
public class Main {	
	
	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
	    
	    
	    int [] a = {67,34,45,6,1,4,3};
	    int [] b = {1,2,9,10,11,15};
	    Node<Integer> p = buildList(a);
	    Node<Integer> h = buildList(b);
	    //System.out.println(ex1(p,h));
	    System.out.println(ex2(p));
	}
	
	public static Node<Integer> buildList(int[] a) {
		Node<Integer> h = new Node<Integer>(-1);
		Node<Integer> p = h;
		Node<Integer> x;
		for (int i = 0; i < a.length; i++) {
			x = new Node<Integer>(a[i]);
			p.setNext(x);
			p = p.getNext();
		}
		return h.getNext();
	}
	
	public static Node<Integer> ex1(Node<Integer> p,Node<Integer> h) 
	{
	    Node<Integer> p1 = p;
		Node<Integer> h1 = h;
		Node<Integer> x = new Node<Integer>(-1);
		Node<Integer> y = x;
		
	    while (p1!=null && h1!=null)
	    {
	        if (p1.getValue() > h1.getValue())
	        {
	            x.setNext(h1);
	            x = x.getNext();
	            h1 = h1.getNext();
	        }
	        else
	        {
	            x.setNext(p1);
	            x = x.getNext();
	            p1 = p1.getNext();
	        }
	    }
	    
	    if (p1==null)
	        x.setNext(h1);
	    else
	        x.setNext(p1);
	    
		return y.getNext();
	}
	
	public static Node<Integer> remove(Node<Integer> p, int n) 
	{
	    Node<Integer> h = p;
	    if (p.getValue() == n)
	        return p.getNext();
	        
	    while (p.getNext()!=null)
	    {
	        if (p.getNext().getValue() == n)
	        {
	            p.setNext(p.getNext().getNext());
	            return h;
	        }
	        p=p.getNext();
	    }
	    return h;
	}
	
	public static Node<Integer> ex2help(Node<Integer> p) 
	{
	    
	    Node<Integer> x = p;
		
	    while (p.getNext()!=null)
	    {
	        if (p.getNext().getValue() < x.getNext().getValue())
	        {
	            x = p;
	        }
	        p = p.getNext();
	    }
	    
		return x;
	}
	
	public static Node<Integer> ex2(Node<Integer> p) 
	{
	    Node<Integer> pp = new Node<Integer>(-1);
	    pp.setNext(p);
		Node<Integer> x = new Node<Integer>(-1);
		Node<Integer> h = x;
		
	    while (pp.getNext()!=null)
	    {
	        x.setNext(ex2help(pp).getNext());
	        pp = remove(pp,ex2help(pp).getNext().getValue());
	        x = x.getNext();
	        
	    }
		return h.getNext();
	}
	


}
