# mars-rover-console

This is a console application which moves rovers over a fictitious plateau on Mars based on user inputs.

###### Note the following
- The application will instruct you as to what input is required at each stage.
- The application will inform you if your input is invalid.
- The application will not allow a rover to move into or pass through a position currently occupied by another rover.
- The application will also not allow the rover to move beyond the boundaries of the plateau.
- Type `exit` to exit the application.

## Getting Started

### 1. Install Java 8
If you don't already have Java 8 installed, grab it from <https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html>.

### 2. Get Your Location Data

Here you can find out how to download your Google data: <https://support.google.com/accounts/answer/3024190?hl=en></br>
Here you can download all of the data that Google has stored on you: <https://takeout.google.com/>

To use this script, you only need to select and download your "Location History", which Google will provide to you as a JSON file by default.

### 3. Clone This Repository
On <https://github.com/luka1199/geo-heatmap>, click the green "Clone or Download" button at the top right of the page. If you want to get started with this script more quickly, click the "Download ZIP" button, and extract the ZIP somewhere on your computer.

### 4. Install Dependencies
In a command prompt or Terminal window, navigate to the directory containing this repository's files. Then, type the following, and press enter:

```
pip install -r requirements.txt
```

### 5. Run the Script
In the same command prompt or Terminal window, type the following, and press enter:
```
python geo_heatmap.py <file>
```
Replace the string `<file>` from above with the path to the `LocationHistory.json` JSON file from Google Takeout.

### 6. Review the Results

The script will generate a HTML file named `heatmap.html`. This file will automatically open in your browser once the script completes. Enjoy!

## FAQ

### I'm getting an "Out of Memory" or `MemoryError` error when I try to run the script. What's going on?
Your `LocationHistory.json` file is probably huge, and Python is running out of memory when the script tries to parse that file.

To fix this, download and install the 64-bit version of Python. To do this:
1. Go to [python.org](https://www.python.org/downloads/).
2. Click the link corresponding to your OS next to "Looking for Python with a different OS?"
3. Click the "Latest Python 3 Release" link.
4. Scroll down to "Files".
5. Click to download the x64 release. For example, on Windows, that's the "Windows x86-64 executable installer" link.
6. Install!