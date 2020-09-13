class Solution {
	// 全局索引
	public int index = 0;

	public boolean isNumber(String s) {
		// 假设字符串的形式为A.BeC或者A.BEC
		// A为整数部分，B为小数部分，C为指数部分，按顺序判断是否包含这三个部分
		//  1. 在字符串最后添加结束标记
		//  2. 使用全局索引index遍历字符串
		//  3. scanInteger扫描有符号整数，用于匹配A和C
		//  4. scanUnsignedInteger扫描无符号整数，用于匹配B
		// 另外需要注意字符串首尾若有空格是合法的
		
		// 特判
		if (s == null || s.length() == 0) 
			return false;
			
		// 字符串s是否是一个数字
		boolean isNum = false;
			
		// Step1: 添加结束标志
		s += '*';
		
		// Step2: 跳过字符串首部的所有空格（如果存在的话）
		while (s.charAt(index) == ' ')
			index++;
		
		// Step3: 整数部分
		isNum = scanInteger(s);
		
		// Step4. 小数部分（如果存在小数点的话）
		if (s.charAt(index) == '.') {
			// 跳过小数点
			index++;
			// 处理小数部分，小数点左右两边只要有一边有数字就合法，所以使用「 || 」
			isNum = scanUnsignedInteger(s) || isNum;
		}
		
		// Step5. 指数部分（如果存在e或E的话）
		if (s.charAt(index) == 'E' || s.charAt(index) == 'e') {
			// 跳过E或e
			index++;
			// 处理指数部分，e或E的两边都必须有数字，所以使用「 && 」
			isNum = scanInteger(s) && isNum;
		}
		
		// Step6. 跳过字符串尾部的所有空格（如果存在的话）
		while (s.charAt(index) == ' ') 
			index++;
			
		// Step7. 看是否遍历到了字符串最后，如果没有到最后的话，一定不是一个数字
		// 如果遍历到了最后且isNum为true，那么s就是一个数字
		isNum = isNum && s.charAt(index) == '*';
		
		return isNum;
		
	}
	
	// 扫描无符号整数，用于匹配B（小数部分）
	// 判断字符串内是否包含无符号数
	public boolean scanUnsignedInteger(String str) {
		// 记下最开始的位置
		int start = index;
		// 是数字就一直遍历下去
		while(str.charAt(index) >= '0' && str.charAt(index) <= '9')
			index++;
		// 若index>start说明发现了无符号整数，否则说明不包含无符号整数
		return index > start;
	}
	
	// 扫描有符号整数，用于匹配A（整数部分）和C（指数部分）
	// 判断字符串内是否包含有符号整数
	public boolean scanInteger(String str) {
		// 如果是有符号的，跳过这个符号，然后把后面的字符串交给scanUnsignedInteger处理
		if (str.charAt(index) == '+' || str.charAt(index) == '-')
			index++;
		return scanUnsignedInteger(str);		
	}	
}
