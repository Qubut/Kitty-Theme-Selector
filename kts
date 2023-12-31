#!/bin/bash

VARS="./env_vars"
source "$VARS"
UTILS="./utilities"
source "$UTILS"
export $(cut -d= -f1 "$VARS")

display_help() {
  echo "Usage: $0 [-h|--help] [-d|--themes-dir <dir>] [-t|--theme-dir <dir>]"
  echo "Choose and apply a theme for the kitty terminal emulator."
  echo "Options:"
  echo "  -h, --help               Display this help message."
  echo "  -d, --themes-dir <dir>   Set the directory where kitty themes are stored. Default is: $CLONING_PATH"
  echo "  -t, --theme-dir <dir>    Set the directory where the current kitty theme's symbolic link is created. Default is: $THEME_PATH"
}
check_args() {
  while [ $# -gt 0 ]; do
    key="$1"

    case $key in
      -h|--help)
        display_help
        exit 0
        ;;
      -d|--themes-dir)
        export CLONING_PATH="$2"
        export THEMES_DIR=$CLONING_PATH/themes
        shift
        ;;
      -t|--theme-dir)
        export THEME_PATH="$2"
        shift
        ;;
      *)
        echo "Invalid option: $key"
        display_help
        exit 1
        ;;
    esac
    shift
  done
}

run() {
  check_args "$@"
  if [ -z "$(ls -A "$THEMES_DIR")" ] || [ ! -d "$THEMES_DIR" ]; then
    echo "No Themes found"
    echo "Cloning to $CLONING_PATH"
    rm -rf "$CLONING_PATH" 2>/dev/null
    clone_themes_from_git
  fi
  create_backup
  THEME=$(choose_theme)
  if [ "$THEME" = "empty" ]; then
    exiting
  elif [ -n "$THEME" ]; then
    apply_theme

  else
    undo_changes
  fi
  refresh_kitty
}

run "$@"
unset_variables_from_file "$VARS"

