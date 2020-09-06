package month2009.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1 {
	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 9, 10, 12};
		int k = 7;
		// 자바 제공하는 최소힙 큐 이용
		System.out.println(usdPriorityQueue(array, k));
		
		// 내가만든 최소힙 클래스를 이용 
		System.out.println(useMakeHeap(array, k));
	}
	
	// PriorityQueue를 이용한 계
	public static int usdPriorityQueue(int[] array, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int num : array) {
			queue.add(num);
		}
		int count =0;
		while(queue.size()>1 && queue.peek() < k) {
			queue.add(queue.poll() + queue.poll() * 2);
			count++;
		}
		if(queue.peek() < k) {
			return -1;
		} else {
			return count;
		}
	}
	
	// 구현한 최소 힙을 이용하여 계산 
	public static int useMakeHeap(int[] array, int k) {
		MinHeap minHeap = new MinHeap(array);
		int count =0;
		while(minHeap.getSize() > 1 && minHeap.getFirst() < k ){
			minHeap.insert(minHeap.delete() + minHeap.delete()*2);
			count++;
		}
		if(minHeap.getFirst() < k) {
			return -1;
		}
		return count;
	}
	
	// 최소힙 구현
	static class MinHeap{
		private List<Integer> heap;
		
		// 기본 생성
		public MinHeap() {
			heap = new ArrayList<Integer>();
			heap.add(0);
		}
		
		// 배열을 받는 생성
		public MinHeap(int[] array) {
			heap = new ArrayList<Integer>();
			heap.add(0);
			for(int num : array) {
				insert(num);
			}
		}
		
		// 요소 삽
		public void insert(int num) {
			heap.add(num);
			int index = heap.size()-1;
			while (index > 1 && heap.get(index / 2) > heap.get(index)){
				int tmp = heap.get(index);
				heap.set(index,  heap.get(index/2));
				heap.set(index/2, tmp);
				index = index / 2;
			}
			
		}
		
		// 요소 삭
		public int delete() {
			// 힙에 내용이 없으면 종료 
			if(heap.size()<2) {
				return -1;
			}

			int deleteNum = heap.get(1);
			
			// 마지막 인덱스의 값을 처음으로 가져오고 마지막 인덱스 삭			
			heap.set(1, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			
			// 마지막에서 가져온 값을 자리에 맞게 배치
			int index = 1;
			while((index*2) <heap.size() ) {
				int min = heap.get(index*2);
				int minIndex = index * 2;
				
				if(index*2+1 < heap.size() 
						&& min > heap.get(index*2+1)) {
					min = heap.get(index*2 +1);
					minIndex = index*2+1;
				}
				
				if(heap.get(index) < min)
					break;
				
				int tmp = heap.get(index);
				heap.set(index, min);
				heap.set(minIndex, tmp);
				index = minIndex;
				
			}
			
			return deleteNum;
		}
		
		// 최상위 요소 확인 
		public int getFirst() {
			return heap.get(1) == null ? -1 : heap.get(1);
		}
		
		// 힙 사이즈 확인 
		public int getSize() {
			return heap.size()-1;
		}
		
	}
}
