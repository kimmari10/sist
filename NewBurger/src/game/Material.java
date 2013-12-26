package game;

//정성을봐서 놔둠
public abstract class Material {
	
	/** 현재 재료의 인덱스 **/
	protected int _nIndex = -1;
	
	/** 재료의 타입 enum **/
	public enum eTYPE {
		Chese,
		Lettuce,
		Patty,
		Bread
	}
	
	
	/**
	 * 현재 재료의 타입이 무었이냐. 치즈냐 레타스냐 패티냐 빵이냐
	 * @return
	 */
	public abstract eTYPE type();
	
	/**
	 * 현재 재료의 인덱스 겟터
	 * @return
	 */
	public abstract int Index();
	
	/**
	 * 현재 재료의 인덱스 셋터 
	 * @param idx
	 */
	public abstract void setIndex(int idx);

}
