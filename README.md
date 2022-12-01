Set up instructions:

Download IntelliJ Community https://www.jetbrains.com/idea/download/#section=mac \
Open VCS, URL: https://github.com/artchaidez/PodiumAutomation.git \
For reference, what was used when creating this project: \
Language: Java \
Build System: Gradle \
JDK: Amazon Corretto 17.0.5 (Windows) \
     Eclipse Temurin 17.0.4
Gradle DSL: Groovy

Notes: TestReturnButtonDoesNotWork() is to prove a bug exists with the return arrow.
On the message widget, clicking on the arrow does not return to the location list
widget.

While not a bug, the classNames for the text fields in the message widget are
inconsistent. The naming convention should be consistent to prevent bugs and issues
for devs and QAs from occurring. Name has two different 'Input',
mobile phone contains an extra 'TextInput' and '--tel', and
message has an extra space at the end.

Name: 'TextInput__FormInput' \
Mobile Phone: 'TextInput TextInput--tel' \
Message: 'TextInput__Textarea ' 

Recommended naming:
Name: 'Name__FormInput' \
Mobile Phone: 'MobileInput__Tel' \
Message: 'Message__Textarea' \