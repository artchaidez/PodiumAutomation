Set up instructions:

// TODO: set this up on my mac and document \
Download IntelliJ Community https://www.jetbrains.com/idea/download/#section=mac \
Download openJDK 17.0.5 \
Open new project in IntelliJ with setup: \
Language: Java \
Build System: Gradle \
JDK: 17.0.5 \
Gradle DSL: Groovy

Notes: TestReturnButtonDoesNotWork() is to prove a bug exists with the return arrow.
On the message widget, clicking on the arrow does not return to the location list
widget. \
While not a bug, the classNames for the text fields in the message widget are
inconsistent. The naming convention should be consistent to prevent bugs and issues
for devs and QAs from occurring. Mobile phone contains an extra 'TextInput', while
message has an extra space at the end. \
Name: 'TextInput__FormInput' \
Mobile Phone: 'TextInput TextInput--tel' \
Message: 'TextInput__Textarea '