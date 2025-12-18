import java.util.*;
public class Main {	
	
	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
	    
	    
	    int [] a = {67,3,4,6,1,4,1,3};
	    int [] b = {1,2,9,10,11,15};
	    Node<Integer> p = buildList(a);
	    Node<Integer> h = buildList(b);
	    //System.out.println(ex1(p,h));
	    //System.out.println(ex2(p));
	    //System.out.println(ex3(p,6));
	    //System.out.println(ex4(p));
	    //System.out.println(ex5(p));
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
	// בהנחה ש - n שווה אורך H + P הסיבוכיות היא O(n)
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
	// בהנחה ש - n שווה אורך P והסיבוכיות היא O(n^2)
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
	
	public static int ex3(Node<Integer> p,int num) 
	// בהנחה ש - n שווה אורך P הסיבוכיות היא O(n)
	{
	    Node<Integer> k = p;
		int start = 0;
		int end = 0;
		
	    while (k!=null)
	    {
	        if (k.getValue() != num)
	            start++;
	            
	        if (k.getValue() == num)
	        {
	            k = k.getNext();
	            while (k!=null)
	            {
	                end++;
	                if (k.getValue() == num)
	                    end = 0;
	                k = k.getNext();
	            }
	            return end + start;
	        }
	        
	        k = k.getNext();
	    }
		return -1;
	}
	
	public static boolean ex4(Node<Integer> p) 
	// בהנחה ש - n שווה אורך P הסיבוכיות היא O(n^2)
	{
		Node<Integer> h = p;
		Node<Integer> k = p.getNext();

		
	    while (h.getNext()!=null)
	    {
	        while (k!=null)
	        {
	            if (h.getValue()==k.getValue())
	                return false;
	            k = k.getNext();
	        }
	        h = h.getNext();
	        k = h.getNext();
	    }
		return true;
	}
	
	public static Node<Integer> ex5(Node<Integer> p) 
	// בהנחה ש - n שווה אורך P הסיבוכיות היא O(n^2)
	{
		Node<Integer> h = ex2(p);
		Node<Integer> k = new Node<Integer>(null);
		Node<Integer> x = k;
		
	    while (h!=null)
	    {
	        if (h.getValue()!=k.getValue())
	        {
	            k.setNext(h);
	            k = k.getNext();
	        }
	        h = h.getNext();
	    }
		return x.getNext();
	}
	
}
