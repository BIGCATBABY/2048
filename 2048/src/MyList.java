

public class MyList<E> {
	public Object[] data;
	public int size;
		public void add(E e){
			//�����µ�����
			Object [] newData =new Object[size+1];
			//��ԭ�������Ԫ�ظ��Ƶ�������������
			for (int i=0;i<size;i++){
				newData[i] = data[i];
			}
			//��Ԫ�طŵ�ԭ��������ȥ
			data = newData;
			//���Ԫ��e
			data[size] = e;
			//���ȼ�һ
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
