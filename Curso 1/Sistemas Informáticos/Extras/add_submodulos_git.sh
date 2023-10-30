#!/bin/bash

submodule_links=(
    # submódulos añadir
    "enlace/git"
)

for submodule_url in "${submodule_links[@]}"
do
    submodule_path=$(basename "$submodule_url" .git)
    echo "Adding submodule from $submodule_url"
    git submodule add "$submodule_url" "$submodule_path"
done
