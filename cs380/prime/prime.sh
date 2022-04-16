#! /bin/bash

echo "Enter the first number"
read a
echo "Enter the second  number"
read b
echo "Enter the third  number"
read c 
if   ! [ $a -gt 1 ]
then echo "enter a positive number"
	exit 3
fi 
if   ! [ $b -gt 1 ]
then echo "enter a positive number"
	exit 3
fi 
if   ! [ $c -gt 1 ]
then echo "enter a positive number"
	exit 3
fi 

function Prime3(){
	echo $1  $2  $3  
	first=$1
	second=$2
	third=$3 
	
	while true 
	do 
	rem= $(( $first % $second ))
	if [ $rem -eq 0 ] 
	then
		ans=$second
	break
	fi
	first= $second
	second= $rem
	done 
	num= $( "$third" % "$ans") 
	
	if [ "$num" -eq 1 ] 
		then echo $1 $2 $3 "are 3-prime"
		exit 0
	else 
		echo $1 $2 $3 "are not 3-prime"  
		exit 1
	fi

}
Prime3 $a $b $c
