var BadWords = /sb|idiot|pussy|dick|shit|ass|damn|fuck|fucking|呆|傻|操|鸟|妈|日|屎|干|幹|艹|靠|粪|鸡巴|鬼|马子|逼|狗|蛋|贱|畜生|混账|羔子|王八|三八|二百五|几巴|几把|屄|杂种|白痴|脑残|神经病|痔疮|屌|卵|龟|阴道|阴户|老二|打飞机|乳|淫|嫖|婊|骚|妓|咪咪|菊花|打炮|吹箫|屁|肛|自慰|肏|操|巴子|老母/gi;

function filterText(sText) {
	return sText.replace(BadWords, "**");
}
