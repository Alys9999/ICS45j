????   < ?  labs/lab1/Main  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Llabs/lab1/Main; problem1_frontMatch 8(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    java/lang/String   length ()I   
     charAt (I)C
     	substring (II)Ljava/lang/String; str Ljava/lang/String; word i I nstr StackMapTable problem2_concatNoDoubles ) java/lang/StringBuilder
  + , - valueOf &(Ljava/lang/Object;)Ljava/lang/String;
 ( /  0 (Ljava/lang/String;)V
  2  3 (I)Ljava/lang/String;
 ( 5 6 7 append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 ( 9 : ; toString ()Ljava/lang/String; a b problem3_darker (III)Ljava/awt/Color; A java/awt/Color
 @ C  D (III)V
 @ F G H darker ()Ljava/awt/Color; red green blue C Ljava/awt/Color; problem4_getDayOfWeek (III)Ljava/lang/String; Q java/util/GregorianCalendar
 P C
 P T U V get (I)I X Sunday Z Monday \ Tuesday ^ 	Wednesday ` Thursday b Friday d Saturday	 f h g java/lang/System i j out Ljava/io/PrintStream;
 l n m java/io/PrintStream o p print (I)V year month 
dayOfMonth dayAsString d Ljava/util/GregorianCalendar; 	dayOfWeek problem5_bigCube .(Ljava/math/BigInteger;)Ljava/math/BigInteger;
 { } | java/math/BigInteger ~ y multiply bigInt Ljava/math/BigInteger; main ([Ljava/lang/String;)V ? labs/lab1/CashRegister
 ? 	@=?     
 ? ? ? ? recordPurchase (D)V@"?     
 ? ? ?  getItemCountInPurchase
 l ? ? p println@I      
 ? ? ? ? receivePayment
 ? ? ? ; 
getReceipt
 l ? ? 0
 ? ? ? ? 
giveChange ()D@>      @$      @4      
 ? ? ? ? getSalesTotal
 l ? ? ?
 ? ? ?  getSalesCount args [Ljava/lang/String; register Llabs/lab1/CashRegister; 
SourceFile 	Main.java !               /     *? ?    
       
             	       ?     :*? +? ? ?=? *? +? ? ??+? ???*+? ? M,?    
   "              #  . " 8 #    *    :   !     : " !    # $  8  % !  &   	 ?  	 '      ?     N*? ? +?+? ? *?**? d? +? ? ? (Y*? *? .+? 1? 4? 8?? (Y*? *? .+? 4? 8?    
       2  3 	 5  6  8 $ 9 ; ;        N < !     N = !  &    	( 	 > ?     b     ? @Y? BN-? EN-?    
       S  T  U    *     I $      J $     K $    L M  	 N O    2     uN? PY? R:? S6?    Q         *   0   6   <   B   H   NWN? $YN? [N? ]N? _N? aN? cN? e? k-?    
   N    i  j  k  l D m G n J o M p P q S r V s Y t \ u _ v b w e x h y k | s }    >    u q $     u r $    u s $   r t !   f u v   ] w $  &    ? D  P 	 x y     B     **? z*? zW**? z*? z?    
   
    ? 
 ?          ?   	 ? ?     ?     x? ?Y? ?L+ ?? ?+ ?? ?? e+? ?? ?+ ?? ?? e+? ?? ?+? ?X+ ?? ?+ ?? ?+ ?? ?+? ?X+ ?? ?+ ?? ?+? ?X? e+? ?? ?? e+? ?? ??    
   F    ?  ?  ?  ?   ? ' ? 1 ? 6 ? = ? D ? K ? P ? W ? ^ ? c ? m ? w ?        x ? ?    p ? ?   ?    ?