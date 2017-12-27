
JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: '====== Begin'.
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(Ljava/lang/Object;)V'
    iface: false.

JVM fieldInsn: #GETSTATIC
    owner: 'java/lang/System'
    name: 'out'
    descr: 'Ljava/io/PrintStream;'.
JVM ldcInsn: ''. "garbage to be popped off the stack, leaving the out stream on the stack"

Smalltalk class class class class class.
JVM methodInsn: #INVOKEVIRTUAL
    owner: 'java/io/PrintStream'
    name: 'println'
    descr: '(Ljava/lang/Object;)V'
    iface: false.

Object subclass: #TestClassBootstrap.

TestClassBootstrap printString