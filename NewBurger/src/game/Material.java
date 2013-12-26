package game;

//���������� ����
public abstract class Material {
	
	/** ���� ����� �ε��� **/
	protected int _nIndex = -1;
	
	/** ����� Ÿ�� enum **/
	public enum eTYPE {
		Chese,
		Lettuce,
		Patty,
		Bread
	}
	
	
	/**
	 * ���� ����� Ÿ���� �����̳�. ġ��� ��Ÿ���� ��Ƽ�� ���̳�
	 * @return
	 */
	public abstract eTYPE type();
	
	/**
	 * ���� ����� �ε��� ����
	 * @return
	 */
	public abstract int Index();
	
	/**
	 * ���� ����� �ε��� ���� 
	 * @param idx
	 */
	public abstract void setIndex(int idx);

}
