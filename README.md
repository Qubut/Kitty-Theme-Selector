# Kitty Theme Selector

The Kitty Theme Selector is a command-line tool written in Bash to choose and apply themes for the kitty terminal emulator. It provides a user-friendly interface for selecting themes from a collection and applying them to the kitty terminal.

## Table of Contents

   - Features
   - Prerequisites
   - Installation
   - Usage
   - Options
   - Themes Repository
   - License

## Features

   - Choose and apply themes for the kitty terminal emulator.
   - Command-line argument support for specifying the themes directory and theme directory.
   - Automatic cloning of the themes repository if no themes are found or the directory is empty.
   - Theme preservation - Backup of the current theme is created before applying a new one.
   - Signal handling for Ctrl+C to ensure graceful cleanup operations and theme restoration.

## Prerequisites

To use this script, you need the following:

1. Bash: The script is written in Bash, so make sure you have a compatible Bash shell available.
2. xdotool: This script uses xdotool to send keystrokes to the terminal for refreshing the kitty theme. Ensure that xdotool is installed and accessible in your system.

## Installation

Clone the repository or download the script:


```bash

git clone https://github.com/yourusername/kitty-theme-selector.git
cd kitty-theme-selector
```

Make the script executable:

```bash

chmod +x kitty-theme-selector.sh
```
## Usage

Run the script with the following command:

```bash

./kitty-theme-selector.sh [options]
```
### Options

The script supports the following command-line options:

    -h, --help: Display the help message.
    -d, --themes-dir <dir>: Set the directory where kitty themes are stored. Default is: themes/.
    -t, --theme-dir <dir>: Set the directory where the current kitty theme link is created. Default is: ~/.config/kitty/theme.conf.

### Themes Repository

By default, it clones themes from a [predefined repository](https://github.com/dexpota/kitty-themes.git), if no themes are found.
If you want to use a different repository, modify the `THEMES_REPO` variable in the env_vars file.

## License

This script is licensed under the MIT License.
