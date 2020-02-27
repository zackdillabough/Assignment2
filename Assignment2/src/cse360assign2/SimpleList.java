/** Name:		 Zack Dillabough
  * ClassID:	 441
  * Assignment:	 1
  * Description: This assignment is designed to practice using github.
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

	private final int INIT_LIST_LENGTH = 10;

	private int[] list;
	private int count;
	private int size;
	
/**
 * This method moves the contents of one list into another 
 * You may also specify whether to copy the list and include a leading '0' in
 * index-0 of the new array.
 * @param arr1 is the array to be copied into another
 * @param arr1Size is the size of the user specified array
 * @param arr2Size is the size of the newly created array
 * @param flag indicates whether the new array will have a leading 0 or not
 * 		  (contents of "arr1" copied to new array after index-0)
 * @return
 */
	private int[] moveList(int[] arr1, int arr1Size, int arr2Size, int flag) {
		int[] newArr = new int[arr2Size];
		for(int index = 0; index < arr1Size; index++) {
			if(flag == 1)
				newArr[index + 1] = arr1[index];
			else
				newArr[index] = arr1[index];
		}
		return newArr;
	}
/**
 * This constructor initializes a SimpleList object with a count of zero,
 * and an empty int-list of size INIT_LIST_LENGTH
 */
	public SimpleList() {
		this.list = new int[INIT_LIST_LENGTH];
		this.count = 0;
		this.size = INIT_LIST_LENGTH;
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
 * then the list's size is increased by 50%
 * @param an int value to be added to the list
 */
	public void add(int userVal) {
		int temp1 = 0;
		int temp2;

		// if this list is full, increase the size by 50%
		if(this.count() == this.size) {
			this.size = this.size + this.size / 2;
			this.list = moveList(this.list, this.count(), this.size, 1);
			this.list[0] = userVal;
		} else {
			// shift all elements by one index value
			// (disposing of the last element, if it exists)
			for(int index = 0; index < this.count(); index ++) {

				if(index == 0) 
					temp1 = this.list[index];

				temp2 = this.list[index + 1];
				this.list[index + 1] = temp1;
				temp1 = temp2;
			}
			// add parameter value to the first index of the list, 
			// and increment count
			this.list[0] = userVal;
		}
			this.count += 1;
	}
	
/**
 * If the parameter exists within the given SimpleList list, 
 * then this method will remove the parameter from the list, shift the other
 * elements, and decrement the list's count. If the list is more than 25%
 * empty, then the size of the list is decreased.
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
					// if the current indexed element is also the last element
					// in the list, then set it equal to 0
					if(index == this.count() - 1)
						this.list[this.count() - 1] = 0;
					// otherwise, remove the target value from list by shifting
					// the other values to "the left" by 1 index 
					// ("covering" the target value)
					else 
						for(int index2 = index; 
								index2 < this.count - 1; index2 ++)
							this.list[index2] = this.list[index2 + 1];

					this.list[this.count() - 1] = 0;
					this.count--;
				}

				index++;
			}
		
		// if the list is less than 75% full, decrease list size by 25%
		if(this.count() < 3 * this.size / 4) {
			this.size = 3 * this.size / 4;
			this.list = moveList(this.list, this.count, this.size, 0);
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

		return -1;
	}

/**
 * This method appends the parameter to the end of the list.
 * If the list is full at the time of calling, then the list's size is
 * increased by 50%
 * @param value to be appended to the list
 */
	public void append(int value) {

		if(this.count() == this.size) {
			this.size = this.size + this.size / 2;
			this.list = moveList(this.list, this.count(), this.size, 0);
			this.list[this.count] = value;
		} else 
			this.list[this.count] = value; 

		this.count += 1;
	}
	
/**
 * This method returns the first element in the list.
 * If there are no elements in the list, -1 is returned.
 * @return the first element in the list (or -1 if the list is empty)
 */
	public int first() {
		int result = -1;
		
		if(this.count != 0)
			result = this.list[0];

		return result;
	}
	
/**
 * This method returns the last element in the list.
 * If there are no elements in the list, -1 is returned.
 * @return the last element in the list (or -1 if the list is empty)
 */
	public int last() {
		int result = -1;
		
		if(this.count != 0)
			result = this.list[count - 1];
		
		return result;
	}
	
/**
 * This method returns the current number of possible locations in the list.
 * @return the current number of possible locations in the list.
 */
	public int size() {
		return this.size;
	}
}