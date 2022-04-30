<h1> Hipo Task </h1>

<p>
  The application is to sort, search and insert itself members taken from a json file.
</p>

<p>
  Inside the MainActivity file, member information is retrieved from assets/hipo.json. Model/member class list is created with member information. The resulting userList is sent to the MemberAdapter and synchronized to the adapter of the recyclerView in activity_main_xml. Thus, the members are listed. For the search, setOnQueryTextListener is used to change the value entered in searcView, and a search is made in member.name and member.position with the entered input value. The userList is updated according to the results.
</p>  
<p align="center">
  <img src="https://github.com/ht1625/android_studies/blob/main/list_getFromJson/ImagesProject/ImageHipoTask1.png" height="400">
</p>

<h1> </h1>
<p>
  When the intern who wants to register clicks on the Register button, it is sent to the AddMember.kt(Register File) page using the intent. Here, the user must fill in the necessary information. When you click on the Register button, the information in the EditText is taken and directed to the MainActivity using intent. A member class is created with the information from MainActivity and added to the userList.
</p>  
<p align="center">
  <img src="https://github.com/ht1625/android_studies/blob/main/list_getFromJson/ImagesProject/ImageHipoTask2.png" height="400">
</p>

<h1> </h1>
<p>
  There is a detail page for members. When the user clicks on the member's name or position, the member's information is directed from MemberAdapter and transferred to MemberDetail.kt with intent. 
</p>  
<p align="center">
  <img src="https://github.com/ht1625/android_studies/blob/main/list_getFromJson/ImagesProject/ImageHipoTask3.png" height="400">
</p>
