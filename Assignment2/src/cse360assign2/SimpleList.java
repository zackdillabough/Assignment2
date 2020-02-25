/** Name:		 Zack Dillabough
  * ClassID:	 441
  * Assignment:	 1
  * Description: This assignment is designed to practice 
  * 			 using Javadoc, creating unit tests and using Junit.
 **/
package cse360assign2;

/**
 * Class Name:	SimpleList
 * Description: A SimpleList is an int array, initialized with size 10. 
 * 				The SimpleList can have up to 10 elements added to it, 
 * 				have elements removed from it, can be searched for an element,
 * 				be observed for its size (not including zeros initialized
 * 				by default), and be represented as a string.
 * @author Zack Dillabough
 */
public class SimpleList {

	private final int LIST_LENGTH = 10;
	private final int NOT_IN_LIST = -1;

	private int[] list;
	private int count;

/**
 * This constructor initializes a SimpleList object with a count of zero,
 * and an empty int-list of size LIST_LENGTH
 */
	public SimpleList() {
		this.list = new int[LIST_LENGTH];
		this.count = 0;
	}

	
/**
 * returns the caller SimpleList's list
 * @return the SimpleList's list
 */
	public int[] getList() {
		return this.list;
	}	

/**
 * This method adds the parameter to the beginning (index = 0) of the list,
 * and moves all the other integers in the list over. If the list is full, 
 * then the last element "falls off" the list.
 * @param an int to be added to the list
 */
	public void add(int a) {
		int temp1 = 0;
		int temp2;

		// make sure the SimpleList's list's count 
		// does not exceed the max list capacity
		if(this.count() < LIST_LENGTH)
			this.count += 1;
		
		// shift all elements by one index value
		// (disposing of the last element, if it exists)
		for(int index = 0; index < this.count() - 1; index ++) {

			if(index == 0) 
				temp1 = this.list[index];

			temp2 = this.list[index + 1];
			this.list[index + 1] = temp1;
			temp1 = temp2;
		}
		// add parameter value to the first index of the list
		this.list[0] = a;
	}
	
/**
 * If the parameter exists within the given SimpleList list, 
 * then this method will remove the parameter from the list, shift the other
 * elements, and decrement the list's count.
 * @param an int to be removed from the list
 */
	public void remove(int target) {
		
		boolean listNotEmpty = this.count() != 0;
		boolean isFound = false;
		int index = 0;
		
		if(listNotEmpty)
			while(!isFound && index < this.count()) {

				if(this.list[index] == target) {
					isFound = true;
					// if the current indexed element is also the last element in the list,
					// then set it equal to 0
					if(index == this.count() - 1)
						this.list[this.count() - 1] = 0;
					// otherwise, remove the target value from list by shifting 
					// the other values to "the left" by 1 index 
					// ("covering" the target value)
					else 
						for(int index2 = index; index2 < this.count() - 1; index2 ++)
							this.list[index2] = this.list[index2 + 1];

					this.list[this.count() - 1] = 0;
					this.count--;
				}

				index++;
			}
	}

/**
 * This method returns the number of items in the given SimpleList's list
 * (not including zeros created by default at array initialization).
 * @return list size
 */
	public int count() { 
		return this.count; 
	}

/**
 * This method returns a string-representation of the given SimpleList's list
 * (not including zeros created by default at array initialization).
 * @return the string-representation of the given list
 */
	public String toString() {

		String str = "";

		for(int index = 0; index < this.count(); index ++) {

			if(index == this.count() - 1)
				str = str + this.list[index];
			else
				str = str + this.list[index] + ' ';
		}

		return str;
	}

/**
 * This method returns the location of the parameter in the list.
 * If the parameter is not in the list, then the method returns -1.
 * @param an int value to check the list for
 * @return the index to the parameter if it is in the list, 
 * 		   or -1 if the parameter is not in the list
 */
	public int search(int value) {

		boolean isInList = false;
		int index = 0;

		while(!isInList && index < this.count()) {

			if(this.list[index] == value)
				return index;

			index += 1;
		}

		return NOT_IN_LIST;
	}
}