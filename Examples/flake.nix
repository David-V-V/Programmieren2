{
  description = "JDK 21 for examples";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs?ref=nixos-unstable";
  };

  outputs = { self, nixpkgs, ... }: 
    let 
      system = "x86_64-linux";
      pkgs = import nixpkgs { inherit system; };
    in {
      devShells.${system}.default = with pkgs; mkShell {
        packages = [ jdk21 ];
      };
    shellHook = ''
      export JAVA_HOME=${pkgs.jdk21}
      PATH="${pkgs.jdk21}/bin:$PATH"
    '';  

  };
}
