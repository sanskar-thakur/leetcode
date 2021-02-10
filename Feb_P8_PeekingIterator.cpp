/*
 * Below is the interface for Iterator, which is already defined for you.
 * **DO NOT** modify the interface for Iterator.
 *
 *  class Iterator {
 *		struct Data;
 * 		Data* data;
 *		Iterator(const vector<int>& nums);
 * 		Iterator(const Iterator& iter);
 *
 * 		// Returns the next element in the iteration.
 *		int next();
 *
 *		// Returns true if the iteration has more elements.
 *		bool hasNext() const;
 *	};
 */

class PeekingIterator : public Iterator {
public:
    int size;
    int current;
    vector<int> numArray;
	PeekingIterator(const vector<int>& nums) : Iterator(nums) {
	    // Initialize any member here.
	    // **DO NOT** save a copy of nums and manipulate it directly.
	    // You should only use the Iterator interface methods.
	    numArray = nums;
        size = nums.size() - 1;
        current = 0;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	int peek() {
        if(current <= size) return numArray[current];
        return -1;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	int next() {
	    if(hasNext()){
            int ans = numArray[current];
            current++;
            return ans;
        }
        return -1;
	}
	
	bool hasNext() const {
	    if(current <= size) return true;
        return false;
	}
};
