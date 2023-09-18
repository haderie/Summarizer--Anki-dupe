# PA02 Summarize this! + Anki Doope
**Compiles FORMATED markdown note files into one whole studyguide.md file ++ compiles questions into a question bank--studyguide.sr**

It includes several additional tools:
1. Gradle Build Automation
1. JaCoCo for Test Coverage
1. CheckStyle for Code Style Checks (Using the custom [cs3500 check file](./config/checkstyle/cs3500-checkstyle.xml)) 
## Format
- #, ##, ###, and #### represent different levels of headings. 
- The `-` indicates a bullet point and bullet points can be nested as well.
- sentences or phrases are enclosed in double square brackets: [[...]].  This is a way to draw attention to particularly important points that the note-taker realizes they’ll definitely need to study later.

## Program Input, 2 Parts:
The program takes three (3) command-line arguments:

1. A **relative or absolute path** to a folder (directory) of markdown files containing the notes you want to summarize.
2. **Ordering Flag** - A flag to indicate how the summary document should be organized
    1. `filename` - organizes content in the output summary file in order based on the alphabetically sorted source file names. 
    2. `created` - organizes content in the output summary file in order based on the create-date time of the source file. 
    3. `modified` - organizes content in the output summary file in order based on the the last modified time of the source file
3. **An output path** (relative or absolute) and filename of where to write the study guide your program generates. Based on the input file processing order dictated by command-line argument #2 above, the output file will contain:
    1. all headings in the order they appear in the file (properly nested). 
        1. Except for the very first line of the study guide file, all headings should be preceded with a blank line. 
    2. all important phrases identified with the `[[]]` properly nested under the heading in which it appears in the original input file. 
        1. In the output file, do not output the brackets themselves. 
        2. Each bracketed phrase should be output as a single bullet point (`-`) in the output file. 
        3. Bracketed phrases or sentences may span multiple lines of the input file. 
        4. A single line of the input file may contain multiple bracketed important phrases; each should be output as a separate bullet point in the study guide
### If there are NO CLI, starts study session
#### however, you MUST run study guide session first in order to create study bank (named studyguide.sr)
- `extracts sentences in '[[ ]]' with '::' in between them to separate questions(left) from answers (right)`

- **all questions are marked as hard in the beginning**
1. Ask the user for a full path to a `.sr` file
2. Ask the user how many questions they’d like to practice in this session
3. Generate a set of questions for this practice session
4. Show each question to the user sequentially
    1. Show the user a menu of options for the question (w) and ask them to enter the appropriate value. 
    2. Update the corresponding question in the model with the user’s response as appropriate
6. After the Study Session is complete, show the session stats: 
    1. the total number of questions answered for that session, 
    2. the total number of questions that changed from easy to hard, 
    3. the total number of questions that changed from hard to easy, 
    4. the updated total number of hard questions in the question bank, and
    5. the updated total number of easy questions in the question bank.

## Sample input and Output
### Input:
<img width="616" alt="Screenshot 2023-09-14 at 1 15 44 PM" src="https://github.com/haderie/Markdown-Study-Guide-Creator/assets/126923741/e08b1050-4196-451a-9dfa-2fe5258aac17">
<img width="612" alt="Screenshot 2023-09-14 at 1 16 26 PM" src="https://github.com/haderie/Markdown-Study-Guide-Creator/assets/126923741/5c60893e-e23e-4b80-9f09-96990407dda3">

### Output:
**studyguide.md file**

<img width="690" alt="Screenshot 2023-09-14 at 1 13 58 PM" src="https://github.com/haderie/Markdown-Study-Guide-Creator/assets/126923741/95003a57-bf7e-4447-98db-12fb00b187ba">

**studyguide.sr file**
<img width="948" alt="Screenshot 2023-09-17 at 11 18 19 PM" src="https://github.com/haderie/Summarizer--Anki-dupe/assets/126923741/641baeb2-0d06-463f-8e6b-2d91d819ef3e">
