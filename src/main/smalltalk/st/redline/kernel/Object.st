
PrimObject subclass: #Object.

- class
    "primitive 111"
    self.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name: 'clazz'
        descr: '()Lst/redline/kernel/PrimObject;'
        iface: false.

- yourself
  ^ self.

- printString
    JVM fieldInsn: #GETSTATIC
        owner: 'java/lang/System'
        name: 'out'
        descr: 'Ljava/io/PrintStream;' .
    JVM varInsn: #ALOAD
        index: 1 .
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'java/io/PrintStream'
        name: 'println'
        descr: '(Ljava/lang/Object;)V'
        iface: false.
    
    ^self.
