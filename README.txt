Note, tests4j is attempting to span multiple jvm apis back 
three minor versions currently on 8/29/2014 from 1.6 - 1.8;
Also as tests4j will always be getting out of date,
it may be a year or so before each new jvm is adopted into 
the framework.

The tests4j/tests4j_4jacoco/tests4j_4gwt apis should only use fairly restricted apis
that span the last 3 minor jvm versions.

The src folder should only use apis that span all three jvms
an additional jvm folder can be attached/removed in eclipse
for the jvm specific api .java source code.
If you want tests4j on a new jvm try to copy,
paste/edit auto generate the tests accordingly.

