# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/build

# Include any dependencies generated for this target.
include CMakeFiles/Oving_3.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Oving_3.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Oving_3.dir/flags.make

CMakeFiles/Oving_3.dir/main.cpp.o: CMakeFiles/Oving_3.dir/flags.make
CMakeFiles/Oving_3.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Oving_3.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/Oving_3.dir/main.cpp.o -c /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/main.cpp

CMakeFiles/Oving_3.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Oving_3.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/main.cpp > CMakeFiles/Oving_3.dir/main.cpp.i

CMakeFiles/Oving_3.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Oving_3.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/main.cpp -o CMakeFiles/Oving_3.dir/main.cpp.s

CMakeFiles/Oving_3.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/Oving_3.dir/main.cpp.o.requires

CMakeFiles/Oving_3.dir/main.cpp.o.provides: CMakeFiles/Oving_3.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/Oving_3.dir/build.make CMakeFiles/Oving_3.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/Oving_3.dir/main.cpp.o.provides

CMakeFiles/Oving_3.dir/main.cpp.o.provides.build: CMakeFiles/Oving_3.dir/main.cpp.o


# Object files for target Oving_3
Oving_3_OBJECTS = \
"CMakeFiles/Oving_3.dir/main.cpp.o"

# External object files for target Oving_3
Oving_3_EXTERNAL_OBJECTS =

Oving_3: CMakeFiles/Oving_3.dir/main.cpp.o
Oving_3: CMakeFiles/Oving_3.dir/build.make
Oving_3: CMakeFiles/Oving_3.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Oving_3"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Oving_3.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Oving_3.dir/build: Oving_3

.PHONY : CMakeFiles/Oving_3.dir/build

CMakeFiles/Oving_3.dir/requires: CMakeFiles/Oving_3.dir/main.cpp.o.requires

.PHONY : CMakeFiles/Oving_3.dir/requires

CMakeFiles/Oving_3.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Oving_3.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Oving_3.dir/clean

CMakeFiles/Oving_3.dir/depend:
	cd /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3 /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3 /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/build /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/build /home/kwecky/Documents/ovingRepo/Ovinger1819/src/algDat/Oving_3/build/CMakeFiles/Oving_3.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Oving_3.dir/depend

