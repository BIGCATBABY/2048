

public class MyList<E> {
	public Object[] data;
	public int size;
		public void add(E e){
			//创建新的数组
			Object [] newData =new Object[size+1];
			//将原数组里的元素复制到新数组里面来
			for (int i=0;i<size;i++){
				newData[i] = data[i];
			}
			//将元素放到原数组里面去
			data = newData;
			//添加元素e
			data[size] = e;
			//长度加一
			size++;
			
		}
		public void delete(int index){
			//build new array 
			Object [] newData = new Object[size-1];
			//copy the former to the later 
			for (int i=0; i<size-1; i++){
				if(i<index){
					newData[i] = data[i];
				}else{
					newData[i] = data[i+1];
				}
				
			}
			//put the elements to the former array
			data = newData;
			size--;
					
		}
		@SuppressWarnings("unchecked")
		public E get(int index){
			
			return (E)data[index];
			
		}
		public void update(int index, E newValue){
			data[index] = newValue;
		}
		public int getSize(){
			return size;
		}
}
