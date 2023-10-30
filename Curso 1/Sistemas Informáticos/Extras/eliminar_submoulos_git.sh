#!/bin/bash

submodules=(
    # Lista de directorios aquí
    "dir/ect/orio"
)

for submodule_path in "${submodules[@]}"
do
    echo "Removing submodule at $submodule_path"
    git submodule deinit "$submodule_path"
    git rm --cached "$submodule_path"
    rm -rf .git/modules/"$submodule_path"
done
