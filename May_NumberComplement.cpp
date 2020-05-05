class Solution {
public:
    int findComplement(int num) {
        /*Nice concept : 
complement of bits is equal to XOR with all set bits*/
        int all_bits_set = pow(2,0);
        for(int i=1; all_bits_set<num; i++)
            all_bits_set += pow(2,i);

        return num xor all_bits_set;
    }
};
