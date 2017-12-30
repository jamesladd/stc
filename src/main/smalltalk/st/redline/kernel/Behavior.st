
Smalltalk import: 'st.redline.kernel.Object'.

Object subclass: #Behavior.

- basicNew
    "primitive 70"
    JVM typeInsn: #NEW
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
    JVM loadVar: self. "add the receiver to the stack"
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'clazz'
        descr: '(Lst/redline/kernel/PrimObject;)V'
        iface: false .
    JVM varInsn: #ALOAD
        index:  3 .
    JVM ldcInsn: 'a '.
    JVM loadVar: self.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'javaValue'
        descr: '()Ljava/lang/Object;'
        iface: false.
    JVM typeInsn: #CHECKCAST
        type: 'java/lang/String'.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'java/lang/String'
        name:  'concat'
        descr: '(Ljava/lang/String;)Ljava/lang/String;'
        iface: false.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'javaValue'
        descr: '(Ljava/lang/Object;)V'
        iface: false.
    JVM varInsn: #ALOAD
        index:  3 .
"    JVM insn: #ARETURN ." "return is automatically added by the close block"

- superclass
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'superclass'
        descr: '()Lst/redline/kernel/PrimObject;'
        iface: false .
    
- superclass: aClass
    JVM loadVar: self .
    JVM typeInsn: #CHECKCAST
        type: 'st/redline/kernel/PrimClass' .
    JVM loadVar: aClass .
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimClass'
        name:  'superclass'
        descr: '(Lst/redline/kernel/PrimObject;)V'
        iface: false .
    ^ self

- atSelector: selector put: aMethod
    JVM loadVar: selector.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'javaValue'
        descr: '()Ljava/lang/Object;'
        iface: false.
    JVM typeInsn: #CHECKCAST
        type: 'java/lang/String'.
    JVM varInsn: #ASTORE
        index: 3.
    JVM loadVar: aMethod.
    JVM typeInsn: #CHECKCAST
        type: 'st/redline/kernel/PrimMethod'.
    JVM varInsn: #ASTORE
        index: 4.
    JVM loadVar: self.
    JVM typeInsn: #CHECKCAST
        type: 'st/redline/kernel/PrimClass'.
    JVM varInsn: #ALOAD
        index: 3.
    JVM varInsn: #ALOAD
        index: 4.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimClass'
        name:  'methodAtPut'
        descr: '(Ljava/lang/String;Lst/redline/kernel/PrimMethod;)Lst/redline/kernel/PrimObject;'
        iface: false.
    ^self
    
+ basicNew
    "primitive 70"
    "Instances of Behavior are PrimClass objects, not just PrimObject."
    JVM typeInsn: #NEW
        type: 'st/redline/kernel/PrimClass' .
    JVM insn: #DUP .
    JVM ldcInsn: 'a Behavior'.
    JVM ldcInsn: false.
    JVM methodInsn: #INVOKESPECIAL
        owner: 'st/redline/kernel/PrimClass'
        name: '<init>'
        descr: '(Ljava/lang/String;Z)V'
        iface: false .
    JVM varInsn: #ASTORE
        index: 3.
    JVM varInsn: #ALOAD
        index:  3 .
    JVM loadVar: self. "add the receiver to the stack"
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'clazz'
        descr: '(Lst/redline/kernel/PrimObject;)V'
        iface: false .
    JVM varInsn: #ALOAD
        index:  3 .

