# Sample Project for Bugs with Android Custom Tabs and custom actions

This project shows issues with the documented options for defining custom actions in Android Custom Tabs.
Using a receiver as recommended in the documentation causes crashes on newer API levels due to restrictions
on activities starting from the background. Using an activity to act as the intermediary works, but only
when Google Chrome is the backing browser and not other browsers like Firefox.
