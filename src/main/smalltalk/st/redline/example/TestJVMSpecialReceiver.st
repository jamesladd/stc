
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.

JVM ldcInsn: 'Hello World'.

JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'print'
    descr: '(Ljava/lang/String;)V'
    iface: false.

JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.

JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '()V'
    iface: false.

JVM typeInsn: #NEW
    type: 'st/redline/kernel/PrimObject' .
JVM insn: #DUP .
JVM methodInsn: #INVOKESPECIAL
    owner: 'st/redline/kernel/PrimObject'
    name: '<init>'
    descr: '()V'
    iface: false .
JVM varInsn: #ASTORE
    index: 3 .

JVM varInsn: #ALOAD
    index: 3 .
JVM ldcInsn: 'test extra JVM messages'.
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'st/redline/kernel/PrimObject'
    name: 'javaValue'
    descr: '(Ljava/lang/Object;)V'
    iface: false .

JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM varInsn: #ALOAD
    index:  3 .
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(Ljava/lang/Object;)V'
    iface: false.
    
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: #testconstant . "compiler currently errors on #'test constant'"
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(Ljava/lang/String;)V'
    iface: false.
    
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: 10 . 
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(I)V'
    iface: false.
    
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: 10 . "-10 breaks the compiler"
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(I)V'
    iface: false.
    
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: 1610 . "Hex numbers, e.g. 16r10, break the compiler"
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(I)V'
    iface: false.
    
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: 11.12 . 
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(F)V'
    iface: false.
    
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: 11.12 . "-11.12 breaks the compiler" 
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(F)V'
    iface: false.
    
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: $c . 
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(C)V'
    iface: false.
