package linkedLists;

import interfaces.LinkedList;
import interfaces.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLDHDTListIterableL2F<E> extends DLDHDTList<E> 
									  implements Iterable<E> 
{
	public Iterator<E> iterator() {
		return new LLIteratorL2F<E>(this);
	}

	private static class LLIteratorL2F<E> 
	implements Iterator<E> 
	{ 
		private LinkedList<E> theList;   // the list to iterate over
		// ... other internal fields ...
		private Node<E> current; 
		private boolean hasMoreElements; 

		public LLIteratorL2F(LinkedList<E> list) {
			theList = list; 
			// ... initialize other internal fields ...
			if(list.length() == 0){
				current = null;
				hasMoreElements = false;
			}else{
				current = list.getLastNode();
				hasMoreElements = true;
			}
		}

		public boolean hasNext() {
			// Write the new code and substitute next statement ....
			return hasMoreElements; 
		}

		public E next() throws NoSuchElementException {
			// Write the new code and substitute next statement ...
			if(!hasMoreElements)
				throw new NoSuchElementException("No more elements in list.");
			E etr = current.getElement();
			try{
				current = theList.getNodeBefore(current);
			}
			catch(NodeOutOfBoundsException e){
				current = null;
				hasMoreElements = false;
			}
			
			return etr;
		}

		public void remove() throws UnsupportedOperationException 
		{
			throw new UnsupportedOperationException("Remove is not implemented.");

		}
	}

}
