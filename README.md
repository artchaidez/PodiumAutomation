Set up instructions:

Download IntelliJ Community https://www.jetbrains.com/idea/download/#section=mac \
Open VCS, URL: https://github.com/artchaidez/PodiumAutomation.git \
For reference, what was used when creating this project: \
Language: Java \
Build System: Gradle \
JDK: Amazon Corretto 17.0.5 (Windows) \
     Eclipse Temurin 17.0.4 (Mac) \
Gradle DSL: Groovy

Notes: TestReturnButtonDoesNotWork() is to prove a bug exists with the return arrow.
On the message modal, clicking on the arrow does not return to the location list
modal. 

When inputting text into the location searchbar, there is already text in the textbox.
On my Windows machine, this will be cleared when new text is input. On Mac, it needs
to be cleared.

While not a bug, the classNames for the text fields in the message modal are
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
