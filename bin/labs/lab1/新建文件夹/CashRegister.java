????   < P  labs/lab1/CashRegister  java/lang/Object purchase D payment it I sales 
salesCount his Ljava/lang/String; <init> ()V Code
    	    	    	    		   
 	    	   	      LineNumberTable LocalVariableTable this Llabs/lab1/CashRegister; recordPurchase (D)V
 ( * ) java/lang/String + , valueOf (D)Ljava/lang/String; . java/lang/StringBuilder
 ( 0 + 1 &(Ljava/lang/Object;)Ljava/lang/String;
 - 3  4 (Ljava/lang/String;)V
 - 6 7 8 append -(Ljava/lang/String;)Ljava/lang/StringBuilder; : 

 - < = > toString ()Ljava/lang/String; amount s receivePayment 
giveChange ()D change getItemCountInPurchase ()I getSalesTotal getSalesCount reset 
getReceipt
 - L 7 M (D)Ljava/lang/StringBuilder; 
SourceFile CashRegister.java !                  	    
      	        	        j     $*? *? *? *? *? *? *? ?    !   "       	          #  "       $ # $    % &     ?     8'? 'N*? -Y*? ? /? 2-? 59? 5? ;? *Y? 'c? *Y? `? ?    !       !  " # # - $ 7 % "        8 # $     8 ?    3 @    A &     C     *Y? 'c? ?    !   
    . 
 / "        # $      ?    B C     u     -*? *? gH*Y? *? c? *Y? `? *? *? '?    !       7 
 8  9 ! : & ; + < "       - # $   
 # D    E F     /     *? ?    !       F "        # $    G C     /     *? ?    !       O "        # $    H F     /     *? ?    !       X "        # $    I      X     *? *? *? *? *? ?    !       _  ` 
 a  b  c  d "        # $    J >     C     ? -Y*? ? /? 2*? ? K? ;?    !       h "        # $    N    O