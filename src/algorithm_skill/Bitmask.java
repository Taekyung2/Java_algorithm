package algorithm_skill;

public class Bitmask {
	public static void main(String[] args) {
		//꽉 찬 집합
		int fullPizza = (1 << 3) - 1;
		
		int toppings = 0;
		//추가
		System.out.println("추가");
		toppings |= (1 << 5);
		toppings |= (1 << 8);
		toppings |= (1 << 15);
		toppings |= (1 << 18);
		
		for(int i = 0; i < 20; i++) {
			if((toppings & (1 << i)) != 0)
				System.out.println(i);
		}
		
		//삭제
		System.out.println("삭제");
		toppings &= ~(1 << 5);
		toppings &= ~(1 << 8);
		for(int i = 0; i < 20; i++) {
			if((toppings & (1 << i)) != 0)
				System.out.println(i);
		}
		
		//원소의 토글
		//1이면 0, 0이면 1
		System.out.println("토글");
		toppings ^= (1 << 5);
		for(int i = 0; i < 20; i++) {
			if((toppings & (1 << i)) != 0)
				System.out.println(i);
		}
		
		System.out.println("갯수");
		System.out.println(bitcount(toppings));
		
		//최하위 비트 찾기
		System.out.println("최하위 비트");
		int firstTopping = (toppings & -toppings);
		for(int i = 0; i < 20; i++) {
			if((firstTopping & (1 << i)) != 0)
				System.out.println(i);
		}
		
		//최하위 비트 삭제
		toppings &= (toppings - 1);
		
		for(int subset = fullPizza; subset != 0; subset = ((subset - 1) & fullPizza)) {
			for(int j = (1 << 2); j > 0; j /= 2) {
				if((subset & j) != 0)
					System.out.print(1);
				else
					System.out.print(0);
			}
			System.out.println();
		}
	}

	static int bitcount(int x) {
		if(x == 0) return 0;
		return x % 2 + bitcount(x / 2);
	}
}
