package easy;

public class NumberComplement476 {
	public static int findComplement(int num) {
		int count = 0;
		int temp = num;
		while (num!=0) {
			count++;//����������λ��
			num = num>>1;
		}
		num = temp;
		temp = (int) ((1<<(count-1))+(Math.pow(2, count-1)-1));//ÿ��������λ����1
		
		return (num^temp);
    }

	public static void main(String[] args) {
		System.out.println(findComplement(5));
		System.out.println(findComplement(1));
	}

}
