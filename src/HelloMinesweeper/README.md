CS224: Project 3 – Hello Minesweeper!


For Project 3, your goal is to create a Minesweeper-style game using JavaFX. If you’ve never played minesweeper before, spend 10 minutes on “research”, there are a number of free versions online including this one: http://minesweeperonline.com/

Grading: 120 Points
20 points: your .git repository. I’m looking for: good commit messages that create a narrative for your project development and regular checkins with small, logical, incremental changes that avoid checking in a lot of cruft.
It is fine for your messages to typically be 1 liners, but they should adhere to good style:
http://chris.beams.io/posts/git-commit/
Your commits should be based around relatively small features. A good practice is to create a todo list, and check this into git with your code. Each item on the todo list should get at least one commit as it is completed and checked off the list (perhaps more if intermediate steps are required). Of course as development continues you may also decide you need to add new todo items, which is entirely fine.
20 points: a clear separation between your model and view-controller components as indicated in the spec
80 points: a solid working implementation of the minesweeper. You should ensure that: the window minesweeper occupies shows the minefield centered within the screen; and that the window cannot get smaller than the minefield (or control bar).
(extra, upto 20 points): Improve your GUI with graphics, perhaps sound, or some improvements to the layout/interaction. Consider adding a timer to track players speed as noted above.