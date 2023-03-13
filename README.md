# Introduction 
TODO: This is the selenium UI Automation POC done for Encyro using JAVA Testng and Maven with Extent report.

# Getting Started with Script Execution
# encyro
1. Install Java and Maven

Install JAVA -https://www.oracle.com/java/technologies/downloads/
download and install maven - https://maven.apache.org/download.cgi

2. Set the home path
Go to My Computer properties -> advanced tab -> environment variables -> new tab of user variable (JAVA_HOME)-> write path in variable name -> write path of bin folder in variable value -> ok -> ok -> ok
similar add JAVA path to the path variable of My Computer properties -> advanced tab -> environment variables ->

Similary set maven home (M2_HOME)


Go to My Computer properties -> advanced tab -> environment variables -> new tab of user variable (M2_HOME)-> write path in variable name -> write path of bin folder in variable value -> ok -> ok -> ok
similar add maven path to the path variable of My Computer properties -> advanced tab -> environment variables ->path
video link to set the java and maven path - https://drive.google.com/file/d/1ZVCjsVsxl_llrWOFF9xA_06945myMSEV/view?usp=sharing
3. Clone the repo
4. Go to the folder
5. Click on the ExecuteScript_chrome.bat or ExecuteScript_edge.bat depending on where you want to execute it.

Once the Results are ready, you will get email to the configured email or Results can also be found in the Results folder
NOTE: Email can be changed by changing email id in below line
message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("hemangihere@gmail.com"));
method name sendEmailReport - Presently in CustUil.java(com.enyro.util)
Video link for the script exection - https://drive.google.com/file/d/17837JdceHajf6ZWff2HN7h6hkZqA_iKR/view?usp=sharing

