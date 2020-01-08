for i in *.less;
do

	if [ "$i" != "definitions.less" ]; then
    	echo $i
    	lessc $i $(echo $i | sed "s/less/css/")
	fi

done
