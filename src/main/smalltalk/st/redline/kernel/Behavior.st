
Smalltalk import: 'st.redline.kernel.Object'.

Object subclass: #Behavior.

+ basicNew
"    JVM typeInsn: #NEW
        type: 'st/redline/kernel/PrimObject' .
    JVM insn: #DUP .
    JVM methodInsn: #INVOKESPECIAL
        owner: 'st/redline/kernel/PrimObject'
        name: '<init>'
        descr: '()V'
        iface: false .
    JVM varInsn: #ASTORE
        index: 3.
    JVM varInsn: #ALOAD
        index:  3 .
    JVM insn: #DUP." "because a new message will pop the previous thing off the stack"
                    "can we make the Smalltalk and JVM usages a little more friendly."
    self. "add the receiver to the stack"
    "JVM varInsn: #ALOAD
        index: 1." "1 is receiver as Lambdas don't have zero as 'this'??"
    "JVM methodInsn: #INVOKEVIRTUAL
        owner:  'st/redline/kernel/PrimObject'
        name:  'clazz'
        descr:  '(Lst/redline/kernel/PrimObject;)V'
        iface:  false .
    JVM varInsn: #ALOAD
        index:  3 ."
"    JVM insn: #ARETURN ." "return is automatically added by the close block"
    ^nil

- printString
    "JVM fieldInsn: #GETSTATIC
        owner: 'java/lang/System'
        name: 'out'
        descr: 'Ljava/io/PrintStream;' .
    JVM varInsn: #ALOAD
        index: 1 ."
    "JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name: 'clazz'
        descr: '()Lst/redline/kernel/PrimObject;'
        iface: false."
    "self class.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'java/io/PrintStream'
        name: 'println'
        descr: '(Ljava/lang/Object;)V'
        iface: false."
    
    ^self.

