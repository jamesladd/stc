
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
    
